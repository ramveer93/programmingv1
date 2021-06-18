/**
 * https://stackify.com/what-is-java-garbage-collection/#:~:text=Java%20garbage%20collection%20is%20the,memory%20dedicated%20to%20the%20program.
 * @author sramveer
 * 
 * 
 * System.gc()
 * 
 * Object created stored in heap(part of mm)
 * parts of heap: young generation(newer object comes here)
 * old generation(most frequent gc happends here)
 * permanent : storage for classes
 * 
 * Types of GC: Hotspot jvm by oracle
 * serial: single thread do the gc
 * parallel: multiple threads do the gc
 * CMS: concurrent
 * G-1 : both parallel and cms
 * 
 * parallelism vs concurrent: concurrency is completing multiple tasks simultaneously , it uses context switching , it can be performed on single cpu
 * parallelism: dividing long task to multiple sub tasks and executing them separately , it cant be done on single cpu, speed increases
 *
 *GC: demon thread, always running on background 
 */
public class GarbageCollection {

}
