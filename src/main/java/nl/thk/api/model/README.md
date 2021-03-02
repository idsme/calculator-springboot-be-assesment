# Improvements

## before refactoring and reusing stuff gets duplicated.

As time is limited... I did not get as far with extracting interfaces from models
and then reusing them.

Especially reusable part interfaces.
Some models contain the same parts. (Remarks, Quality, Timestamps)
Which you might not want to show or not show.. By building a projection
from these parts you can choose what to show.

see part package.