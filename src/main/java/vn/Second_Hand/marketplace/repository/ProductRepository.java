package vn.Second_Hand.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.Second_Hand.marketplace.entity.Product;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByDanhMuc_MaDanhMuc(int maDanhMuc);

    @Query("SELECT p FROM Product p ORDER BY p.daBan DESC LIMIT 10")
    List<Product> findTop10BestSellers();

    @Query("SELECT p FROM Product p WHERE p.ngayTaoSP >= :sevenDaysAgo ORDER BY p.ngayTaoSP DESC LIMIT 10")
    List<Product> findProductsCreatedLast7Days(@Param("sevenDaysAgo") Date sevenDaysAgo);
}
