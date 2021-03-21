package leetcode

const base = 409

type entry struct {
	key, value int
	next       *entry
}

type MyHashMap struct {
	entrySet []*entry
}

/** Initialize your data structure here. */
func Constructor() MyHashMap {
	return MyHashMap{make([]*entry, 409)}
}

/** value will always be non-negative. */
func (this *MyHashMap) Put(key int, value int) {
	var index int = key % 409
	if this.entrySet[index] == nil {
		this.entrySet[index] = &entry{key, value, nil}
	} else if this.entrySet[index].key == key {
		this.entrySet[index].value = value
	} else {
		var cur *entry = this.entrySet[index].next
		var pre *entry = this.entrySet[index]
		for cur != nil && cur.key != key {
			pre = cur
			cur = cur.next
		}
		if cur != nil {
			cur.value = value
		} else {
			pre.next = &entry{key, value, nil}
		}
	}
}

/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
func (this *MyHashMap) Get(key int) int {
	var cur *entry = this.entrySet[key%409]
	for cur != nil && cur.key != key {
		cur = cur.next
	}
	if cur == nil {
		return -1
	}
	return cur.value
}

/** Removes the mapping of the specified value key if this map contains a mapping for the key */
func (this *MyHashMap) Remove(key int) {
	var index int = key % 409
	if this.entrySet[index] == nil {
		return
	} else if this.entrySet[index].key == key {
		this.entrySet[index] = this.entrySet[index].next
	} else {
		var cur *entry = this.entrySet[index].next
		var pre *entry = this.entrySet[index]
		for cur != nil && cur.key != key {
			pre = cur
			cur = cur.next
		}
		if cur != nil {
			pre.next = cur.next
		}
	}
}
