# Python Syntax for LeetCode
# This file contains Python syntax examples for solving LeetCode problems.

'''
# Variables 
hello = "Hello, World!"
num = 1
array = [1, 2, 3] #Array

# Classes
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

node = ListNode(1)
print(node.val)
print(node.next)

# Loops
# Print array one by one
arr = [ 1, 2, 3, 4] 
for i in range(len(arr)):
    print (arr[i])
print("-----")
# Print array index backwards 
index = len(arr) - 1
while index >= 0:
    print (index)
    index -= 1

# Booleans
result = True or False
result2 = True and (False and False)
result3 = 2 == 1
print(result3) # Returns false

# Max / min
maxi = max(5, 2)
mini = min(5, 2)
print(maxi, mini)

dictionary = {}
{
    "key": "value"
}
dictionary[10] = "Codes"
dictionary["A"] = 10
print (dictionary)

if "A" in dictionary:
    print("TRUE")
else:
    print("False")

dictionary["A"] = 3
dictionary["A"] += 1 

'''

# Variables are dynamicaly typed; determined at runtime
n, m = 0, "abc" #its okay to have diff types in same line
n, m, z = 0.125, "abc", False

# Increment 
n = n +1
n += 1
# n++ 

# None is null (Absence of value)
n = 4
n = None
print("n=", n)

# If statements dont need parentheses or curly braces
n = 1
if n > 2:
    n -= 1
elif n == 2:
    n *= 2
else:
    n += 2

# Parentheses needed for multi-line conditions
# and = &&
# or = ||


















