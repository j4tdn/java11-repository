package dao;

import connection.DbManager;
import persistence.ItemGroupDto;
import utils.SqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemGroupDaoImpl implements ItemGroupDao {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;

    public ItemGroupDaoImpl() {
        connection = DbManager.getConnection();
    }

    @Override
    public List<ItemGroupDto> getAvailableItemsByGroupId() {
        List<ItemGroupDto> result = new ArrayList<>();

        String sql = "SELECT lh.MaLH MaLoai,\n" +
                     "       lh.TenLH TenLoai,\n" +
                     "       SUM(ctmh.SoLuong) SoLuong\n" +
                     "FROM loaihang lh\n" +
                     "JOIN mathang mh\n" +
                     "ON lh.MaLH = mh.MaLH\n" +
                     "JOIN chitietmathang ctmh\n" +
                     "ON mh.MaMH = ctmh.MaMH\n" +
                     "GROUP BY lh.MaLH";

        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                // transformer
                ItemGroupDto itemGroupDto = new ItemGroupDto(rs.getInt("MaLoai"), rs.getString("TenLoai"), rs.getInt("SoLuong"));
                result.add(itemGroupDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, pst);
        }

        return result;
    }
}
