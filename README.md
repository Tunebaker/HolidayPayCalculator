Simple API to calculate vacation pay. You can:

1. Calculate by average monthly salary and vacation duration. 
Syntax: /calculate?salary=(_salary_amount_)&duration=(_days_), where
   - _salary_amount_ has a numeric non-negative type double (may have or may not have decimal delimiter)
   - _days_ has an integer type and should be 1 or more;

2. Calculate by average monthly salary and explicitly given dates when vacation starts and ends (inclusively). In this case 
the holidays number will be subtracted from calculated vacation duration. Syntax:
   /calculate?salary=(_salary_amount_)&vacationStart=(_dd-MM-yy_)&vacationEnd=(_dd-MM-yy_)