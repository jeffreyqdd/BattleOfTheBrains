import random

with open("testdat", "w") as f:
	f.write("500 500\n")
	for i in range(500):
		f.write(" ".join([str(random.randint(0, 999)) for j in range(500)]) + "\n")
