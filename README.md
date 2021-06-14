```
Benchmark                               Mode  Cnt       Score      Error  Units
Test.in_place_list_creation            thrpt    6   26125,186 ±  511,005  ops/s
Test.list_to_set                       thrpt    6    6529,104 ±  727,250  ops/s
Test.static_interned_list              thrpt    6   38716,333 ±  793,851  ops/s
Test.static_interned_list_classic_for  thrpt    6   41168,939 ±  411,300  ops/s
Test.static_interned_list_iterator     thrpt    6   35296,859 ± 4318,004  ops/s
Test.static_list                       thrpt    6   38840,577 ±  655,293  ops/s
Test.static_list_classic_for           thrpt    6   38158,359 ±  268,005  ops/s
Test.static_list_iterator              thrpt    6   36957,221 ± 4734,883  ops/s
Test.static_set                        thrpt    6  351443,456 ± 2678,563  ops/s
```