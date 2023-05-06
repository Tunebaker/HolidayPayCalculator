Simple API to calculate vacation pay. You can:

1. Calculate by average monthly salary and vacation duration. 
Syntax: **/calculate?salary=(_salary_amount_)&duration=(_days_),** where
   - _salary_amount_ parameter has a numeric non-negative type double (may have or may not have decimal delimiter)
   - _days_ parameter has an integer type and should be 1 or more;

2. Calculate by average monthly salary and explicitly given dates when vacation starts and ends (inclusively). In this 
case the holidays number will be subtracted from calculated vacation duration. Syntax:
   **/calculate?salary=(_salary_amount_)&vacationStart=(_dd-MM-yy_)&vacationEnd=(_dd-MM-yy_)**

Please note that current version uses pre-downloaded from http://xmlcalendar.ru/ file calendar.xml which contains 
the non-working day list for year 2023 only, so calculations for any other year will return wrong result.