create accommodations view by_host as
select h.*, COUNT(s.id) as smestuvanja
from host h
         join smestuvanje s on h.id = s.host_id
group by h.id

create hosts view by_country
select c.*,COUNT(h.id) as domakini
from country c
         join host h on c.id = h.country_id
group by c.id


-- create or replace view products_per_category as
-- select c.id        as category_id,
--        count(p.id) as num_products
-- from category c
--          left join
--      product p on p.category_id = c.id
-- group by c.id;
--
-- create materialized view products_per_manufacturers as
-- select m.id        as manufacturer_id,
--        count(p.id) as num_products
-- from manufacturers m
--          left join
--      product p on p.manufacturer_id = m.id
-- group by m.id;
