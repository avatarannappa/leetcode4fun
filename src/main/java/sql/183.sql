-- 183. 从不订购的客户 2020/7/3
select Name Name from Customers where id NOT IN (select CustomerId from Orders);