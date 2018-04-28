package TestNG.TestNGStoreService;

import com.SWEProject.Entities.History;
import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.User;
import com.SWEProject.repository.*;
import com.SWEProject.service.ProductService;
import com.SWEProject.service.storeService;
import jdk.nashorn.internal.runtime.StoredScript;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class StoreServiceTest {

    @Mock
    StoreRepository storeRep;
    @Mock
    ProductRepository productRep;
    @Mock
    HistoryRepository historyRep;

    @InjectMocks
    storeService storeService;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void testAddStoreSuccess() {
        Store store = new Store("laura","Apple", "online");

        when(storeRep.exists(store.getStorename())).thenReturn(false);
        when(storeRep.save(store)).thenReturn(store);
        Assert.assertEquals(true, storeService.addStore(store));
    }

    @Test
    public void testAddStoreFailure() {
        Store store = new Store("laura","Apple", "online");

        when(storeRep.exists(store.getStorename())).thenReturn(true);
        Assert.assertEquals(false, storeService.addStore(store));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testGetStoreListSuccess() {
        List<Store> storeList = new ArrayList<>();
        when(storeRep.findAll()).thenReturn(storeList);
        Assert.assertEquals(storeList, storeService.getStoreList());
    }

    @Test
    public void testGetStoreListFailure() {
        List<Store> storeList = new ArrayList<>();
        when(storeRep.findAll()).thenReturn(storeList);
        Assert.assertEquals(null, storeService.getStoreList());
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAddToHistory() {
        User user = new User("laura" , "laura","laura","storeOwner","laura","",100000);

        Product product = new Product("iphone","jojo",100,"4s","Apple",10,2,true);
        History history = new History();
        product.setSerialnumber(-1);
        when(productRep.save(product)).thenReturn(product);
        when(historyRep.save(history)).thenReturn(history);
        Assert.assertEquals(true, storeService.addToHistory(product,user.getUsername(),user.getType(),user.getStorename()));
    }

}