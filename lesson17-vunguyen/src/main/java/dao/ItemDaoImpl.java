package dao;

import connection.DbManager;
import persistence.ItemByDateDto;
import persistence.ItemByItemGroupDto;
import persistence.ItemBySaleDto;
import persistence.ItemGroup;
import utils.DateUtils;
import utils.SqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;

    public ItemDaoImpl() {
        connection = DbManager.getConnection();
    }

    @Override
    public List<ItemByDateDto> get(LocalDate orderDate) {
        List<ItemByDateDto> result = new ArrayList<>();
        String sql = "SELECT mh.MaMH,\n" +
                     "       mh.TenMH,\n" +
                     "       dh.ThoiGianDatHang\n" +
                     "FROM mathang mh\n" +
                     "JOIN chitietdonhang ctdh\n" +
                     "ON mh.MaMH = ctdh.MaMH\n" +
                     "JOIN donhang dh\n" +
                     "ON ctdh.MaDH = dh.MaDH\n" +
                     "WHERE CAST(dh.ThoiGianDatHang AS DATE) = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setDate(1, DateUtils.toDate(orderDate));
            rs = pst.executeQuery();
            while (rs.next()) {
                ItemByDateDto itemByDateDto = new ItemByDateDto(rs.getInt("MaMH"), rs.getString("TenMH"), DateUtils.toLocalDate(rs.getDate("ThoiGianDatHang")));
                result.add(itemByDateDto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, pst);
        }
        return result;
    }

    @Override
    public List<ItemBySaleDto> get(int year) {
        List<ItemBySaleDto> result = new ArrayList<>();

        String sql = "SELECT mh.MaMH,\n" +
                     "       mh.TenMH,\n" +
                     "       COUNT(mh.MaMH) SoLuong\n" +
                     "FROM mathang mh\n" +
                     "JOIN chitietdonhang ctdh\n" +
                     "ON mh.MaMH = ctdh.MaMH\n" +
                     "JOIN donhang dh\n" +
                     "ON ctdh.MaDH = dh.MaDH\n" +
                     "WHERE YEAR(dh.ThoiGianDatHang) = ?\n" +
                     "GROUP BY mh.MaMH\n" +
                     "LIMIT 3";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, year);
            rs = pst.executeQuery();
            while (rs.next()) {
                // transformer
                ItemBySaleDto itemBySaleDto = new ItemBySaleDto(rs.getInt("MaMH"), rs.getString("TenMH"), rs.getInt("SoLuong"));
                result.add(itemBySaleDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, pst);
        }

        return result;
    }

    @Override
    public List<ItemByItemGroupDto> getItemByItemGroups() {
        List<ItemByItemGroupDto> result = new ArrayList<>();

        String sql = "SELECT lh.MaLH MaLoai,\n" +
                     "       lh.TenLH TenLoai,\n" +
                     "       mh.MaMH,\n" +
                     "       mh.TenMH,\n" +
                     "       ctmh.GiaBan,\n" +
                     "       ctmh.GiaMua,\n" +
                     "       ctmh.SoLuong,\n" +
                     "       kc.MoTa\n" +
                     "FROM loaihang lh\n" +
                     "JOIN mathang mh\n" +
                     "ON lh.MaLH = mh.MaLH\n" +
                     "JOIN chitietmathang ctmh\n" +
                     "ON mh.MaMH = ctmh.MaMH\n" +
                     "JOIN kichco kc\n" +
                     "ON ctmh.MaKC = kc.MaKC";

        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                // transformer
                ItemByItemGroupDto itemByItemGroupDto = new ItemByItemGroupDto(rs.getInt("MaLoai"),
                                                                               rs.getString("TenLoai"),
                                                                               new ItemGroup(rs.getInt("MaMH"), rs.getString("TenMH")),
                                                                               rs.getInt("GiaBan"),
                                                                               rs.getInt("GiaMua"),
                                                                               rs.getInt("SoLuong"),
                                                                               rs.getString("MoTa"));
                result.add(itemByItemGroupDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.close(rs, pst);
        }

        return result;
    }
}
