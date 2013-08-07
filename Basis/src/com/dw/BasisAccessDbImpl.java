package com.dw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import com.dw.model.basis.events.Events;
import com.dw.model.basis.events.Exercise;
import com.dw.model.basis.events.Notification;
import com.dw.model.basis.events.Sleep;
import com.dw.model.basis.events.TimePeriod;
import com.dw.model.basis.metrics.BodyState;
import com.dw.model.basis.metrics.Metrics;
import com.dw.model.basis.metrics.Observation;

public class BasisAccessDbImpl {

	private Connection con = null;

	// Constructor:
	BasisAccessDbImpl() {
		con = getConx();
	}

	public void close() {
		try {
			if (con != null)
				con.close();
			con = null;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean isClosed() {
		boolean returnValue = true;
		try {
			returnValue = con.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	public void writeMetrics(Metrics d) {
		insertObservations(d.getMetrics().getObservations());
		insertBodystates(d.getBodystates());
	}

	public void writeEvents(Events e) {
		insertSleepEvents(e.getSleepEvents());
		insertTimePeriodEvents(e.getTimePeriodEvents());
		insertExerciseEvents(e.getExerciseEvents());
		insertNotificationEvents(e.getNotificationEvents());
	}

	void insertObservations(List<Observation> observations) {
		try {

			PreparedStatement ps = con.prepareStatement("INSERT INTO STG_OBSERVATIONS VALUES (?, ?, ?, ?, ?, ?, ?)");

			for (Observation obs : observations) {

				// TODO - Define constants for magic numbers
				ps.setTimestamp(1, new java.sql.Timestamp(obs.getObservationDate().getTime()));

				setDouble(ps, 2, obs.getAirTemp());
				setDouble(ps, 3, obs.getCalories());
				setDouble(ps, 4, obs.getGsr());
				setInt(ps, 5, obs.getHeartrate());
				setDouble(ps, 6, obs.getSkinTemp());
				setInt(ps, 7, obs.getSteps());

				ps.execute();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			handleSQLException(e);
		}

	}

	void insertBodystates(List<BodyState> bodystates) {
		try {

			// TODO - Define constants for magic numbers
			PreparedStatement ps = con.prepareStatement("INSERT INTO STG_BODYSTATES VALUES (?, ?, ?)");

			for (BodyState bbs : bodystates) {

				// TODO - Define constants for magic numbers
				ps.setTimestamp(1, new java.sql.Timestamp(bbs.getStartTime().getTime()));
				ps.setTimestamp(2, new java.sql.Timestamp(bbs.getEndTime().getTime()));
				ps.setString(3, bbs.getBodystate());

				ps.execute();

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			handleSQLException(e);
		}

	}

	void insertSleepEvents(List<Sleep> sleepEvents) {

		try {

			// TODO - Define constants for magic numbers
			PreparedStatement ps = con.prepareStatement("INSERT INTO STG_SLEEP VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			for (Sleep s : sleepEvents) {

				ps.setString(1, s.getId());
				setDouble(ps, 2, s.getCalories());
				ps.setString(3, s.getDay());
				setInt(ps, 4, s.getDuration());
				setInt(ps, 5, s.getDurationAwoken());
				ps.setTimestamp(6, new java.sql.Timestamp(s.getEndTime().getTime()));
				ps.setTimestamp(7, new java.sql.Timestamp(s.getEventTime().getTime()));
				setInt(ps, 8, s.getHeartRate());
				setDouble(ps, 9, s.getQuality());
				setInt(ps, 10, s.getPoints());
				ps.setTimestamp(11, new java.sql.Timestamp(s.getStartTime().getTime()));
				setInt(ps, 12, s.getTimesAwoken());
				setInt(ps, 13, s.getTzOffset());

				ps.execute();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			handleSQLException(e);
		}

	}

	void insertExerciseEvents(List<Exercise> exerciseEvents) {

		try {

			// TODO - Define constants for magic numbers
			PreparedStatement ps = con.prepareStatement("INSERT INTO STG_EXERCIZE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			for (Exercise e : exerciseEvents) {

				ps.setString(1, e.getId());
				setDouble(ps, 2, e.getCalories());
				setDouble(ps, 3, e.getCaloriesAvg());
				ps.setString(4, e.getDay());
				setInt(ps, 5, e.getDuration());
				ps.setTimestamp(6, new java.sql.Timestamp(e.getEndTime().getTime()));
				ps.setTimestamp(7, new java.sql.Timestamp(e.getEventTime().getTime()));
				setInt(ps, 8, e.getPoints());
				setTimestamp(ps, 9, e.getStart());
				ps.setTimestamp(10, new java.sql.Timestamp(e.getStartTime().getTime()));
				setInt(ps, 11, e.getSteps());
				setInt(ps, 12, e.getTzOffset());

				ps.execute();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			handleSQLException(e);
		}

	}

	void insertNotificationEvents(List<Notification> notificationEvents) {

		try {

			// TODO - Define constants for magic numbers
			PreparedStatement ps = con.prepareStatement("INSERT INTO STG_NOTIFICATION VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			for (Notification n : notificationEvents) {

				ps.setString(1, n.getId());
				ps.setTimestamp(2, new java.sql.Timestamp(n.getEventTime().getTime()));
				ps.setString(3, n.getHabitDisplay());
				ps.setString(4, n.getHabitName());
				ps.setString(5, n.getDate());
				setInt(ps, 6, n.getPoints());
				setInt(ps, 7, n.getQuota());
				setTimestamp(ps, 8, n.getStart());
				setInt(ps, 9, n.getTzOffset());

				ps.execute();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			handleSQLException(e);
		}

	}

	void insertTimePeriodEvents(List<TimePeriod> timePeriodEvents) {

		try {

			// TODO - Define constants for magic numbers
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO STG_TIME_PERIOD VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			for (TimePeriod t : timePeriodEvents) {

				ps.setString(1, t.getId());
				ps.setString(2, t.getType());
				setInt(ps, 3, t.getActivity());
				setInt(ps, 4, t.getActivity_count());
				ps.setString(5, t.getActivity_goal());
				setInt(ps, 6, t.getCalories());
				setDouble(ps, 7, t.getCalories_avg());
				setInt(ps, 8, t.getCalories_goal());
				ps.setString(9, t.getDay());
				setInt(ps, 10, t.getDays());
				ps.setTimestamp(11, new java.sql.Timestamp(t.getEventTime().getTime()));
				setInt(ps, 12, t.getHabits_hit());
				setInt(ps, 13, t.getHabits_quota_met());
				setInt(ps, 14, t.getHabits_total());
				setInt(ps, 15, t.getPoints());
				setDouble(ps, 16, t.getResting_heartrate());
				setInt(ps, 17, t.getSleep());
				setDouble(ps, 18, t.getSleep_avg());
				setDouble(ps, 19, t.getSleep_quality());
				ps.setString(20, t.getStart());
				setInt(ps, 21, t.getSteps());
				setDouble(ps, 22, t.getSteps_avg());
				setInt(ps, 23, t.getSteps_goal());
				setInt(ps, 24, t.getTimes_awoken());
				ps.setString(25, t.getTimezone());
				setInt(ps, 26, t.getTzOffset());

				ps.execute();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			handleSQLException(e);
		}

	}

	private Connection getConx() {

		String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
				+ BasisProperties.getInstance().getProperty(BasisProperties.DB_PATH);

		if (con == null) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection(url, "", "");
			} catch (SQLException ex) {
				handleSQLException(ex);
			} catch (ClassNotFoundException clex) {
				clex.printStackTrace();
			}
		} else
			try {
				if (con.isClosed()) {
					con = DriverManager.getConnection(url, "", "");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				handleSQLException(e);
			}
		return con;
	}

	private PreparedStatement setDouble(PreparedStatement ps, int index, Double value) {
		try {
			if (value != null) {
				ps.setDouble(index, value);
			} else {
				ps.setNull(index, Types.DOUBLE);
			}
			return ps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			handleSQLException(e);
		}
		return ps;
	}

	private PreparedStatement setInt(PreparedStatement ps, int index, Integer value) {
		try {
			if (value != null) {
				ps.setInt(index, value);
			} else {
				ps.setNull(index, Types.INTEGER);
			}
			return ps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			handleSQLException(e);
		}
		return ps;
	}

	private PreparedStatement setTimestamp(PreparedStatement ps, int index, Date value) {
		try {
			if (value != null) {
				ps.setTimestamp(index, new java.sql.Timestamp(value.getTime()));
			} else {
				ps.setNull(index, Types.TIMESTAMP);
			}
			return ps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			handleSQLException(e);
		}
		return ps;
	}

	private void handleSQLException(SQLException e) {
		e.printStackTrace();
	}
}