-- 586,easy,订单最多的客户
select customer_number 
from orders 
group by customer_number 
order by count(customer_number) 
desc
limit 1;