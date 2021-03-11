package leetcode

type MyQueue struct {
	inStack, outStack []int
}

/** Initialize your data structure here. */
func Constructor_s232() MyQueue {
	return MyQueue{}
}

/** Push element x to the back of queue. */
func (this *MyQueue) Push(x int) {
	this.inStack = append(this.inStack, x)
}

/** Removes the element from in front of queue and returns that element. */
func (this *MyQueue) Pop() int {
	res := -1
	if this.Empty() {
		return res
	}
	if len(this.inStack) != 0 {
		res = this.inStack[0]
		this.inStack = this.inStack[1:]
	} else {
		res = this.outStack[len(this.outStack)-1]
		this.outStack = this.outStack[:len(this.outStack)-1]
	}
	return res
}

/** Get the front element. */
func (this *MyQueue) Peek() int {
	if this.Empty() {
		return -1
	}
	if len(this.inStack) != 0 {
		return this.inStack[0]
	} else {
		return this.outStack[len(this.outStack)-1]
	}
}

/** Returns whether the queue is empty. */
func (this *MyQueue) Empty() bool {
	if len(this.inStack) == 0 && len(this.outStack) == 0 {
		return true
	}
	return false
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Peek();
 * param_4 := obj.Empty();
 */
