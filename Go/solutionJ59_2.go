package leetcode

type MaxQueue struct {
	queue []int
	arr   []int
}

func Constructor_sJ59_2() MaxQueue {
	return MaxQueue{make([]int, 0), make([]int, 0)}
}

func (this *MaxQueue) Max_value() int {
	if len(this.queue) != 0 {
		return this.queue[0]
	}
	return -1
}

func (this *MaxQueue) Push_back(value int) {
	for len(this.queue) != 0 && this.queue[len(this.queue)-1] < value {
		this.queue = this.queue[:len(this.queue)-1]
	}
	this.queue = append(this.queue, value)
	this.arr = append(this.arr, value)
}

func (this *MaxQueue) Pop_front() int {
	if len(this.arr) > 0 {
		res := this.arr[0]
		this.arr = this.arr[1:]
		if res == this.queue[0] {
			this.queue = this.queue[1:]
		}
		return res
	} else {
		return -1
	}
}
