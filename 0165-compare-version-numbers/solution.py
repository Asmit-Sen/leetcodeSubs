class Solution(object):
        
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        list1=[]
        list2=[]
        for x in list(version1.split('.')):
            list1.append(int(x))
        for x in list(version2.split('.')):
            list2.append(int(x))

        print(list1)
        print(list2)

        i,j = 0,0
        n=len(list1)
        m=len(list2)

        while(i<n or j<m):
            if(i>=n):
                if(list2[j]==0):
                    j+=1
                    continue
                else:
                    return -1
            if(j>=m):
                if(list1[i]==0):
                    i+=1
                    continue
                else:
                    return 1

            if(list1[i]!=list2[j]):
                if (list1[i]>list2[j]):
                    return 1
                else:
                    return -1

            i+=1
            j+=1
        return 0
        
        
