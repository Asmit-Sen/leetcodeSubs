# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        # map <value, node ref>
        map = {}

        # track which node is the parent
        children = []

        for node in descriptions:

            par = node[0]
            child = node[1]
            isleft = node[2]

            children.append(child)

            if (par not in map):
                # create the parent
                parnode = TreeNode(par)
                map[par] = parnode

            if (child not in map):
                # create the child
                childnode = TreeNode(child)
                map[child] = childnode

            if isleft:
                map[par].left = map[child]
            else:
                map[par].right = map[child]

        for key in map.keys():
            if key not in children:
                return map[key]

        return null

        

