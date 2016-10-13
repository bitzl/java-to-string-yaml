# Using YAML as toString Representation

Using YAML as toString Representation has several advantages:

  - toString() does not change if any fields in the class changes
  - Output of to string (e.g. from Logfiles) can be taken tto recreate the Object for tests
 
 Disadvantages:
 
  - very limited possibilites to influence toString() output
  - classes that are not Pojos might nead *Constructor* and *Representer* classes