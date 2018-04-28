package TestNG.TestNGBrandService;

import com.SWEProject.Entities.Brand;
import com.SWEProject.repository.BrandRepository;
import com.SWEProject.service.BrandService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BrandServiceTest {

    BrandService brandService = new BrandService();

//    @Mock
//    BrandRepository brandRepository;
//
//    @InjectMocks
//    BrandServiceImp brandServiceImp;
//
//    @BeforeMethod
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//    }





    @DataProvider(name = "brandSuccess")
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
    }

}