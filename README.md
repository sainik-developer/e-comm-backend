


## create databases

Here I am using H2 as database (To avoid installing mysql)

1. table 1 
user_id | user_name | password
2. table 2 
product_id | product_name | product_image | product_desc | product_price | product_quantity

## Spring boot is used for backend REST end point
1. JWT is used for authentication 
2. JPA used to retrieve the data from database
3. Stripe is used for payment purpose

## Strip create price
stripe prices create  \
--currency=INR \
--unit-amount=1000 \
-d "product_data[name]"="Gold Plan"

## React is used for UI development

stripe listen --forward-to localhost:5000/webhook
stripe login

