package com.zee.zee5app.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;

public class WebSeriesIdGenerator extends SequenceStyleGenerator {
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Movie movie = (Movie) object;
		Connection connection = null;
		connection = session.connection();
		PreparedStatement preparedStatement = null;
		String query = "select id from useridgenerator";
		String updatequery = "update useridgenerator set id=? where id=?";
		ResultSet resultSet = null;
		int old_id;
		// connection object

		try {
			// get old id from useridgenerator table and increment the id and append it for
			// userid
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next() == true) {
				int num = resultSet.getInt(1);
				old_id = num;
				num++;
				int length_of_id = (int) (Math.log10(num) + 1);
				String movieid = movie.getMovieName().substring(0, 2) + "0".repeat(10 - 2 - length_of_id) + num;

				// update the incremented id to useridgenerator table
				preparedStatement = connection.prepareStatement(updatequery);
				preparedStatement.setInt(1, num);
				preparedStatement.setInt(2, old_id);
				int res = preparedStatement.executeUpdate();
				if (res == 0)
					throw new UnableToGenerateIdException("Unable to generate id");

				// return userid
				return movieid;
			}
		} catch (SQLException | UnableToGenerateIdException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return null;

	}

}
