create materialized  view by_host as
select h.id,
       h.name,
       h.surname,
       h.country_id, COUNT(s.id) as smestuvanja
from host h
         join smestuvanje s on h.id = s.host_id
group by h.id;

create materialized view by_country as
select c.id,
       c.name,
       c.continent, COUNT(h.id) as domakini
from country c
         join host h on c.id = h.country_id
group by c.id;
