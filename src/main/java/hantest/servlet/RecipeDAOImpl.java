package hantest.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAOImpl implements RecipeDAO {
	private static final String INSERT_STMT = "INSERT INTO RECIPE(IDRECIPE, TEXT, DESCRIP, PHOTO) VALUES (?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE RECIPE SET TEXT = ?, DESCRIP = ?, PHOTO = ? WHERE IDRECIPE = ?";
	private static final String DELETE_STMT = "DELETE FROM RECIPE WHERE IDRECIPE = ?";
	private static final String FIND_BY_PK = "SELECT * FROM RECIPE WHERE IDRECIPE = ?";
	private static final String GET_ALL = "SELECT * FROM RECIPE";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public void insert(RecipeVO recipeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1,recipeVO.getIdRecipe());
			pstmt.setString(2,recipeVO.getText());
			pstmt.setString(3,recipeVO.getDescrip());
			pstmt.setBytes(4,recipeVO.getPhoto());
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

		
	@Override
	public void update(RecipeVO recipeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setString(1,recipeVO.getText());
			pstmt.setString(2,recipeVO.getDescrip());
			pstmt.setBytes(3,recipeVO.getPhoto());
			pstmt.setInt(4,recipeVO.getIdRecipe());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}


	@Override
	public void delete(int idRecipe) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, idRecipe);
			
			pstmt.executeUpdate();


			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public RecipeVO findByPK(int idRecipe) {
		RecipeVO rcp = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, idRecipe);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rcp = new RecipeVO();
				rcp.setIdRecipe(rs.getInt("IDRECIPE"));
				rcp.setText(rs.getString("TEXT"));
				rcp.setDescrip(rs.getString("DESCRIP"));
				rcp.setPhoto(rs.getBytes("PHOTO"));
				
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return rcp;
	}

	@Override
	public List<RecipeVO> getAll() {
		List<RecipeVO> rcpList = new ArrayList<>();
		RecipeVO rcp = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rcp = new RecipeVO();
				rcp.setIdRecipe(rs.getInt("IDRECIPE"));
				rcp.setText(rs.getString("TEXT"));
				rcp.setDescrip(rs.getString("DESCRIP"));
				rcp.setPhoto(rs.getBytes("PHOTO"));
				rcpList.add(rcp);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return rcpList;
	}

}