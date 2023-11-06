select * from customers inner join orders on customers.cid = orders.cid;
// compare cid of orders and cid of customers

select * from customers right outer join orders on customers.cid = orders.cid;

select * from (customers left outer join orders on customers.cid = orders.cid) left outer join products on products.pid = orders.pid;
