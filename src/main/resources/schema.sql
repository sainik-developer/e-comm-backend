CREATE TABLE products (
   id VARCHAR(50) NOT NULL,
   name VARCHAR(50) NOT NULL,
   image VARCHAR(200) NOT NULL,
   desc VARCHAR(20) NOT NULL,
   price VARCHAR(20) NOT NULL,
   quantity INT NOT NULL
);

CREATE TABLE users (
   id VARCHAR(50) NOT NULL,
   user_name VARCHAR(50) NOT NULL,
   password VARCHAR(20) NOT NULL
);


INSERT INTO products VALUES('834e142e-0ef0-43c6-a4b3-d56a15ed3bf6', 'Product Description 1','https://magecomp.com/blog/wp-content/uploads/2018/05/How-to-Get-Product-Image-URL-in-Magento-2-1024x512.png','Product Name 1',1000,10)
--INSERT INTO products
--VALUES('834e142e-0ef0-43c6-a4b3-d56a15ed3bf9', 'Product Description 2','https://magecomp.com/blog/wp-content/uploads/2018/05/How-to-Get-Product-Image-URL-in-Magento-2-1024x512.png','Product Name 2',900,10)
--INSERT INTO products
--VALUES('834e142e-0ef0-43c6-a4b3-d56a15ed3bf5', 'Product Description 3','https://magecomp.com/blog/wp-content/uploads/2018/05/How-to-Get-Product-Image-URL-in-Magento-2-1024x512.png','Product Name 3',800,10)