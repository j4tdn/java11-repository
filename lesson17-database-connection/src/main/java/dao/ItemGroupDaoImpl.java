package dao;

import connection.DbManager;
import persistence.ItemGroup;
import utils.SqlUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemGroupDaoImpl implements ItemGroupDao {

    private Connection connection;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public ItemGroupDaoImpl() {
        connection = DbManager.getConnection();
    }

    @Override
    public List<ItemGroup> getAll() {
        List<ItemGroup> result = new ArrayList<>();

        // 1. Write down a native query
        String sql = "SELECT MALH, TENLH FROM LOAIHANG";

        // 2. Execute the native query and return data

        try {
            // 2.1 Initial Statement || PrepareStatement object
            st = connection.createStatement();

            // 2.2 Pass native query into Statement || PrepareStatement & call executeQuery || excuteUpdate from Statement || Prepare to execute native query.
            rs = st.executeQuery(sql);
            while (rs.next()) {
                // transformer
                Integer id = rs.getInt("MaLH");
                String name = rs.getString("TenLH");
                ItemGroup itemGroup = new ItemGroup(id, name);
                result.add(itemGroup);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, st);
        }

        return result;
    }

    @Override
    public ItemGroup get(int id) {
        ItemGroup result = null;
        String sql = "SELECT * FROM LOAIHANG\n" +
                     "WHERE MaLH = " + id;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                // transformer
                result = new ItemGroup(rs.getInt("MaLH"),
                                       rs.getString("TenLH"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, st);
        }

        return result;
    }

    @Override
    public boolean save(ItemGroup itemGroup) {
        boolean result = false;

        Integer id = itemGroup.getId();
        String name = itemGroup.getName();

        // UPDATE >> INSERT, UPDATE, DELETE
        String sql = "INSERT INTO LOAIHANG(MaLH, TenLH)\n" +
                     "VALUES(" + id + ", '" + name + "')";

        try {
            // statement >> execute complete SQL statement with full parameters
            st = connection.createStatement();
            int affectedRows = st.executeUpdate(sql);

            result = affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(st);
        }
        return result;
    }

    @Override
    public boolean update(ItemGroup itemGroup) {
        boolean result = false;

        Integer id = itemGroup.getId();
        String name = itemGroup.getName();

        String sql = "UPDATE LoaiHang \n" +
                     "SET TenLH = ? \n" +
                     "WHERE MaLH = ?";

        try {
            // prepare statement >> represent a precompiled SQL statement and pass the parameter then
            pst = connection.prepareStatement(sql);

            // set parameter, complete SQL with parameter
            pst.setString(1, name);
            pst.setInt(2, id);

            int affectedRows = pst.executeUpdate();
            result = affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(pst);
        }
        return result;
    }

    // Problem >>
    // 1. SQL(Statement) >> complicated in case of many parameters
    // 2. save ==> saveOrUpdate
}
