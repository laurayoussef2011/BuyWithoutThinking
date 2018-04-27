package com.SWEProject.service;

import com.SWEProject.Entities.Brand;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BrandServiceTest {

    BrandService brandService = new BrandService();

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
                {" "},
                {"zxcvbnmasdfghjklqwertyuiop1234567890"}
        };
    }

    @DataProvider(name = "brandError")
    public static Object[][] Test_AddBrand_Error()
    {
        return new Object[][]{
                {""}
        };
    }

    @Test(dataProvider = "brandSuccess")
    public void testBrandCheckAvailable(String tempBrandName)
    {
        Brand tempbrand = new Brand(tempBrandName);
        Assert.assertEquals(true, brandService.brandCheckAvailable(tempbrand));
    }

    @Test(dataProvider = "brandFailure")
    public void testBrandCheckAvailableFailure(String tempBrandName)
    {
        Brand tempbrand = new Brand(tempBrandName);
        Assert.assertEquals(false, brandService.brandCheckAvailable(tempbrand));
    }

    @Test(dataProvider = "brandError")
    public void testBrandCheckAvailableError(String tempBrandName)
    {
        Brand tempbrand = new Brand(tempBrandName);
        Assert.assertEquals(false, brandService.brandCheckAvailable(tempbrand));
    }
}