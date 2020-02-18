package com.example.demo.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private JdbcTemplate jdbcTemplate;

	public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Iterable<Product> findAll() {
		return jdbcTemplate.query("select id, name, type from MY_TEST", new ProductRowMapper());
	}

	@Override
	public List<Product> findOneById(String id) {
		return jdbcTemplate.query("select id, name, type from MY_TEST where id=?", new ProductRowMapper(), id);
	}

	@Override
	public Product save(Product product) {
		jdbcTemplate.update("insert into MY_TEST (id,name,type) values (?,?,?)",
				product.getId(),
				product.getName(),
				product.getType());
		return product;
	}

	@Override
	public String delete(String id) {
		jdbcTemplate.update("delete from MY_TEST where id=?",id);
		return id;
	}

	private static class ProductRowMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet resultSet, int i) throws SQLException {
			return new Product(resultSet.getString("id"),
					resultSet.getString("name"),
					resultSet.getString("type"));
		}
	}
}
