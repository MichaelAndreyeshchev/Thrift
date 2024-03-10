service kvstorage {
  bool ping(),
  string get(1: string key),
  i32 put(1: string key, 2:string val)
}


