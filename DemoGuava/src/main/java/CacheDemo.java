//import com.google.common.cache.Cache;
//import com.google.common.cache.CacheBuilder;
//import com.google.common.cache.CacheLoader;
//import java.util.concurrent.Callable;
//import java.util.concurrent.TimeUnit;
//
//public class CacheDemo {
//
//  Cache<String, String> cache = CacheBuilder.newBuilder().build();
//
//  private String getFromCache(final String key) {
//    return cache.get(key, new Callable<String>() {
//      @Override
//      public String call() throws Exception {
//        return getStringFromDB(key);
//      }
//    });
//
//
//  }
//
//
//  public static void main(String[] args) {
//
//    CacheBuilder<Object, Object> cacheBuiler = CacheBuilder.newBuilder();
//
//    cacheBuiler.maximumSize(1000L);
//    cacheBuiler.expireAfterAccess(100, TimeUnit.MINUTES);
//    cacheBuiler.refreshAfterWrite(100, TimeUnit.MINUTES);
//
////    cacheBuiler.build(new CacheLoader<String, String>() {
////      @Override
////      public String load(String key) throws Exception {
////
////
////        return this.getStringFromDB(key);
////      }
////    });
//
//  }
//
//
//  private String getStringFromDB(String key) {
//    System.out.println("db invoked");
//    return "sssss";
//  }
//
//
//}
