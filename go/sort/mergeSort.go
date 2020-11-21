package main

func MergeSort(arr []int) []int {
	if arr == nil || len(arr) == 0 {
		return make([]int, 0)
	} else if len(arr) < 2 {
		return arr
	}

	mid := len(arr) / 2

	return merge(MergeSort(arr[:mid]), MergeSort(arr[mid:]))
}

func merge(left []int, right []int) []int {
	ans := make([]int, len(left) + len(right))

	for k, i, j := 0, 0, 0; k < len(ans); k++ {
		if i < len(left) && j < len(right) {
			if left[i] < right[j] {
				ans[k] = left[i]
				i++
			} else {
				ans[k] = right[j]
				j++
			}
		} else if i >= len(left) {
			ans[k] = right[j]
			j++
		} else {
			ans[k] = left[i]
			i++
		}
	}

	return ans
}
