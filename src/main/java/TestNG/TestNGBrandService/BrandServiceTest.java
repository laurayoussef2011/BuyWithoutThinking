package TestNG.TestNGBrandService;

import com.SWEProject.Entities.Brand;
import com.SWEProject.repository.BrandRepository;
import com.SWEProject.service.BrandService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.any;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class BrandServiceTest {

    @Mock
    BrandRepository brandRep;

    @InjectMocks
    BrandService brandService;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void brandCheckAvailableTrue() throws Exception {
        String brandName = "OnePlus";
        Brand brand = new Brand(brandName);

        when(brandRep.save(brand)).thenReturn(brand);
        assertEquals(true,brandService.brandCheckAvailable(brand));
    }

    @Test
    public void brandCheckAvailableFalse() throws Exception {
        String brandName = "OnePlus";
        Brand brand = new Brand(brandName);

        when(brandRep.save(brand)).thenReturn(null);
        assertEquals(false,brandService.brandCheckAvailable(brand));
    }




    /*@DataProvider(name = "brandSuccess")
    public static Object[][] Test_AddBrand_Success()
    {
        return new Object[][]{
                {"apple"},
                {"Samsung"},
                {"club aldo"}
        };
    }

    @DataProvider(name = "brandFailure")
    public static Object[][] Test_AddBrand_Failure()
    {
        return new Object[][]{
                {""},
                {"apple"} // exists brand
        };
    }

    @Test(dataProvider = "brandSuccess")
    public void testBrandCheckAvailable(String tempBrandName)
    {
        Brand tempBrand = new Brand(tempBrandName);
        Assert.assertEquals(true, brandService.brandCheckAvailable(tempBrand));
    }

    @Test(dataProvider = "brandFailure")
    public void testBrandCheckAvailableFailure(String tempBrandName)
    {
        Brand tempBrand = new Brand(tempBrandName);
        Assert.assertEquals(false, brandService.brandCheckAvailable(tempBrand));
    }*/

}