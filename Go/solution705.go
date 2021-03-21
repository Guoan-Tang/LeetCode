package leetcode

type Node struct {
	next *Node
	val  int
}

type MyHashSet struct {
	set []*Node
}

/** Initialize your data structure here. */
func Constructor_s705() MyHashSet {
	return MyHashSet{make([]*Node, 409)}
}

func (this *MyHashSet) Add(key int) {
	var index int = key % 409
	if this.set[index] == nil {
		this.set[index] = &Node{nil, key}
	} else {
		var temp *Node = this.set[index]
		for temp.val != key && temp.next != nil {
			temp = temp.next
		}
		if temp.val != key {
			temp.next = &Node{nil, key}
		}
	}
}

func (this *MyHashSet) Remove(key int) {
	var index int = key % 409
	if this.set[index] == nil {
		return
	} else {
		if this.set[index].val == key {
			this.set[index] = this.set[index].next
			return
		}
		var pre *Node = this.set[index]
		var cur *Node = pre.next
		for cur != nil && cur.val != key {
			pre = cur
			cur = cur.next
		}
		if cur != nil {
			pre.next = cur.next
		}
	}
}

/** Returns true if this set contains the specified element */
func (this *MyHashSet) Contains(key int) bool {
	var index int = key % 409
	if this.set[index] == nil {
		return false
	}
	var cur *Node = this.set[index]
	for cur != nil && cur.val != key {
		cur = cur.next
	}
	if cur != nil {
		return true
	}
	return false
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Add(key);
 * obj.Remove(key);
 * param_3 := obj.Contains(key);
 */
