package main

func bubbleSort(nums []int) []int {
	if nums == nil || len(nums) == 0 {
		return make([]int, 0)
	}

	for i := 0; i < len(nums); i++ {
		for j := 0; j < len(nums) - 1 - i; j++  {
			if nums[j] > nums[j + 1] {
				tmp := nums[j]
				nums[j] = nums[j + 1]
				nums[j + 1] = tmp
			}
		}
	}
	return nums
}
