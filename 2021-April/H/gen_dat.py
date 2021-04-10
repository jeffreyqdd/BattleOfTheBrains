import random

n = 10
k = 5

def countsetbits(x):
	numset = 0
	while x > 0:
		numset += x & 1
		x = x >> 1
	return numset

with open("testdat", "w") as f:
	f.write(str(n) + " " + str(k) + "\n")
	feats = []
	for i in range(n):
		s = 0
		for j in range(k):
			s = s << 1
			if random.random() < 0.5:
				s += 1


		feats.append(s)

	minsimilar = 0
	minsimilarcount = 21

	for x in range(2**k):
		maxsim = 0
		for y in feats:
			maxsim = max(maxsim, k - countsetbits(x ^ y))
		if maxsim < minsimilarcount:
			minsimilarcount = maxsim
			minsimilar = x

	s = bin(minsimilar).split("b")[1]
	s = "0" * (k - len(s)) + s
	print(s, minsimilarcount)

	for x in feats:
		s = bin(x).split("b")[1]
		s = "0" * (k - len(s)) + s
		f.write(s + "\n")
