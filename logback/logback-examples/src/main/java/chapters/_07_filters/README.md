
- https://logback.qos.ch/manual/filters.html

Filters are organized as an ordered list and are based on ternary logic. The decide(ILoggingEvent event) method of each filter is called in sequence. 

This method returns one of the FilterReply enumeration values, i.e. one of DENY, NEUTRAL or ACCEPT. 
- If the value returned by decide() is DENY, then the log event is dropped immediately without consulting the remaining filters. 
- If the value returned is NEUTRAL, then the next filter in the list is consulted. If there are no further filters to consult, then the logging event is processed normally. 
- If the returned value is ACCEPT, then the logging event is processed immediately skipping the invocation of the remaining filters.
