package vn.Second_Hand.marketplace.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maSanPham;
    private int idChuSP;
    private String tenSP;

    @ManyToOne
    @JoinColumn(name = "maDanhMuc", nullable = false)
    private Category danhMuc;

    private String giaBanDau;
    private String giaHienTai;
    private int soLuong;
    private String xuatXu;
    private String baoHanh;
    private String tinhTrang;
    private String moTaTinhTrang;
    private String motaSP;
    private String anhBanDau;
    private String anhHienTai;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTaoSP;
    private int daBan;
}
