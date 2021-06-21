package org.kochi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.kochi.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void create(Board board) throws Exception {
		String query = "INSERT INTO board (title, content, writer) VALUES(?,?,?)";
		jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
	}
	@Override
	public Board read(Integer boardNo) throws Exception {
		String query = "SELECT board_no, title, content, writer, reg_date FROM board WHERE board_no = ?";
		List<Board> res = jdbcTemplate.query(query, 
				new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Board board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getDate("reg_date"));
				return board;
			}
		}, boardNo);
		// 쿼리의 결과값을 지정해서 리스트로 기록하는 쿼리, jdbcTemplate이 지원해준다.
		return res.isEmpty() ? null : res.get(0);	// 게시판 한 개를 받아오기 때문에 첫번째 값을 가져오면 된다.
	}
	@Override
	public void update(Board board) throws Exception {
		String query = "UPDATE board SET title = ?, content = ? WHERE board_no = ?";
		jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());
	}
	@Override
	public void delete(Integer boardNo) throws Exception {
		String query = "DELETE FROM board WHERE board_no = ?";
		jdbcTemplate.update(query, boardNo);
	}
	@Override
	public List<Board> list() throws Exception {
		String query = "SELECT board_no, title, content, writer, reg_date FROM board WHERE board_no > 0 ORDER BY board_no desc, reg_date DESC";
		List<Board> res = jdbcTemplate.query(query, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Board board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getDate("reg_date"));
				return board;
			}
			
		});
		return res;	// 리스트는 read와 코드가 거의 흡사하며, 리턴값만 한가지 값에서 리스트 자체를 반환한다.
	}
}
