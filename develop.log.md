# Developer Log

### text search vector design
We create a new table to textSearch, so that all the 
text search function will visit textsearch table.

1. testSearch table schema
    only 2 columns are there in textSearch, id and tsv.
    A trigger was create on insertion or update of blogs 
    so that each modification will be captured, and content 
    will be vectorized and added  into textSearch. 
2. insertion on textSearch
    A trigger named ts_update controls insertion on textSearch.
3. text search process
    query will first be operated on textSearch, 
    and db will return matched ids. And then we will get the blog list with the returned id.

4. delete cascading
    I added a constraint 'blog_tsv_id_constraint' to 
    make sure deletion on blogs will be cascaded to textSearch.
  