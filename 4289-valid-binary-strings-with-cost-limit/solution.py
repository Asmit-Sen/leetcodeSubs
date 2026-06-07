class Solution:
    def f(self, i, n, k, s, list):
        if (i==n):
            list.append(s)
            return

        self.f(i+1, n, k, s+'0', list)
        if (i==0 or (k>=i and s[-1]=='0')):
            self.f(i+1, n, k-i, s+'1', list)

    def generateValidStrings(self, n: int, k: int) -> list[str]:
        list = [] 
        self.f(0, n, k, "", list)
        return list
