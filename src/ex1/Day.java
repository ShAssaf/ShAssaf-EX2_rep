package ex1;

import static java.util.Comparator.comparing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Day {

	// --------------Data Member--------------

	private ArrayList<Event> events_arr = new ArrayList<Event>();
	private int day;
	private int month;
	private int year;

	// --------------Adding Methods--------------

	// ___________add_event___________
	// input - event
	// output - None

	public void add_event(Event event) {
		this.events_arr.add(event);
		if (event instanceof Meeting) {
			((Meeting) event).get_contact().add_meeting((Meeting) event);
		}
		this.get_events_arr().sort(Comparator.comparing(Event::get_date));
	}

	// --------------Removing Methods--------------

	// ___________remove_event___________
	// input - event
	// output - None

	public void remove_event(Event event) {
		this.events_arr.remove(event);
	}

	public Map<String, ArrayList> create_temporal_array() {
		ArrayList<Pair<String, Integer>> temp_arr = new ArrayList<Pair<String, Integer>>();
		ArrayList<Pair<Integer, LocalDateTime>> ls = new ArrayList<Pair<Integer, LocalDateTime>>();
		int idx = 1;
		for (Event event : this.get_events_arr()) {
			ls.add(new Pair<Integer, LocalDateTime>(idx, event.get_date()));
			ls.add(new Pair<Integer, LocalDateTime>(idx, event.get_date().plusMinutes(event.get_duration())));
			idx++;
		}
		final Comparator<Pair<Integer, LocalDateTime>> c = comparing(Pair::getR);
		Collections.sort(ls, c);
		Boolean[] b = new Boolean[ls.size() / 2];
		Arrays.fill(b, Boolean.TRUE);
		for (Pair<Integer, LocalDateTime> p : ls) {
			if (b[p.getL() - 1]) {
				temp_arr.add(new Pair<String, Integer>("s", p.getL()));
				b[p.getL() - 1] = !b[p.getL() - 1];
			} else {
				temp_arr.add(new Pair<String, Integer>("e", p.getL()));
			}

		}
		Map<String, ArrayList> ret_hash = new HashMap<String, ArrayList>();
		ret_hash.put("original", ls);
		ret_hash.put("temporal", temp_arr);
		return ret_hash;
	}

	public ArrayList<Pair<String, Integer>> get_overlapping(ArrayList<Pair<String, Integer>> temp_arr) {
		ArrayList<Pair<String, Integer>> new_ls = new ArrayList<Pair<String, Integer>>();
		int idx = 0;
		int pair_num = 0;
		Pair<String, Integer> p = temp_arr.get(pair_num);
		while (pair_num <= temp_arr.size() - 1) {
			if (p.getL().equals("s")) {
				idx = p.getR();
			} else {
				while (p.getL().equals("e")) {
					pair_num++;
					if (pair_num <= temp_arr.size() - 1) {
						p = temp_arr.get(pair_num);
					} else {
						break;
					}
				}
				idx = p.getR();
			}

			while (true) {
				pair_num++;
				if (pair_num <= temp_arr.size() - 1) {
					p = temp_arr.get(pair_num);
					if (p.getR() != idx) {
						new_ls.add(p);
					} else {
						break;
					}
				} else {
					break;
				}
			}
		}
		return new_ls;
	}

	public ArrayList<Pair<String, Integer>> lists_subtraction(ArrayList<Pair<String, Integer>> original,
			ArrayList<Pair<String, Integer>> overlap) {
		ArrayList<Pair<String, Integer>> sub = new ArrayList<Pair<String, Integer>>();
		ArrayList<Pair<String, Integer>> res = new ArrayList<Pair<String, Integer>>();
		for (Pair<String, Integer> p : original) {
			if (!(overlap.contains(p))) {
				sub.add(p);
			}
		}
		for (Pair<String, Integer> p : sub) {
			if (p.getL().equals("s")) {
				res.add(p);
			}
		}
		return res;
	}

	public ArrayList<Event> temp_to_events(ArrayList<Pair<String, Integer>> res,
			ArrayList<Pair<Integer, LocalDateTime>> original) {
		ArrayList<LocalDateTime> times = new ArrayList<LocalDateTime>();
		ArrayList<Event> events_res = new ArrayList<Event>();
		ArrayList<Integer> idx_list = new ArrayList<Integer>();
		for (Pair<String, Integer> p : res) {
			if (!(idx_list.contains(p.getR()))) {
				idx_list.add(p.getR());
			}
		}
		for (Pair<Integer, LocalDateTime> p : original) {
			if (idx_list.contains(p.getL())) {
				times.add(p.getR());
			}
		}
		for (Event event : this.get_events_arr()) {
			if (times.contains(event.get_date())) {
				events_res.add(event);
			}
		}
		return events_res;
	}

	// ___________remove_overlapping_events___________
	// input - None
	// output - None
	// in case of overlapping events, removes the events that starts later
	public void remove_overlapping_events() {
		Map<String, ArrayList> ret_hash = this.create_temporal_array();
		ArrayList<Pair<String, Integer>> overlap_arr = this.get_overlapping(ret_hash.get("temporal"));
		ArrayList<Pair<String, Integer>> res = this.lists_subtraction(ret_hash.get("temporal"), overlap_arr);
		ArrayList<Event> events = this.temp_to_events(res, ret_hash.get("original"));
		this.events_arr = events;
	}

	// --------------Setters--------------

	private void set_events_arr(ArrayList<Event> events_arr) {
		this.events_arr = events_arr;
	}

	private void set_day(int day) {
		this.day = day;
	}

	private void set_month(int month) {
		this.month = month;
	}

	private void set_year(int year) {
		this.year = year;
	}

	// --------------Getters--------------

	public ArrayList<Event> get_events_arr() {
		return this.events_arr;
	}

	public int get_day() {
		return this.day;
	}

	public int get_month() {
		return this.month;
	}

	public int get_year() {
		return this.year;
	}

	// --------------Printers--------------

	public void print_event(Event event) {
		event.print();
	}

	public void print_all_events() {
		for (Event event : this.get_events_arr()) {
			this.print_event(event);
		}
	}

	// --------------Constructor--------------

	public Day(ArrayList<Event> events_arr, int day, int month, int year) {
		this.set_events_arr(events_arr);
		this.set_day(day);
		this.set_month(month);
		this.set_year(year);
		this.get_events_arr().sort(Comparator.comparing(Event::get_date));
	}

	public Day(ArrayList<Event> events_arr, LocalDateTime date) {
		this.set_events_arr(events_arr);
		this.set_day(date.getDayOfMonth());
		this.set_month(date.getMonthValue());
		this.set_year(date.getYear());
		this.get_events_arr().sort(Comparator.comparing(Event::get_date));
	}

	public Day() {
		this.set_day(0);
		this.set_month(0);
		this.set_year(0);

	}

}
