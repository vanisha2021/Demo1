package com.example.restapidemoapp;


import com.example.restapidemoapp.entities.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductrestapiTest {
    @Value("${demoproductrestapi.services.url}")
    private String BASE_URL;
@Test
    public void testGetProduct()
{
    RestTemplate restTemplate=new RestTemplate();
    Product product=restTemplate.getForObject(BASE_URL+"1", Product.class);
    assertNotNull(product);
    assertEquals("bike",product.getName());
}
@Test
public void testCreateProduct()
{
    RestTemplate restTemplate=new RestTemplate();
    Product product=new Product();
    product.setName("car");
    product.setDescription("blue");
    product.setPrice(9000);
    Product response=restTemplate.postForObject(BASE_URL,product,Product.class);
    assertNotNull(response);
    assertNotNull(response.getId());
    assertEquals("car",response.getName());
}
@Test
 public void testUpdateProduct()
{
    RestTemplate restTemplate=new RestTemplate();
    Product product;
    product = restTemplate.getForObject(BASE_URL+"4",Product.class);
    product.setPrice(1111);
    restTemplate.put(BASE_URL,product);
}
}
