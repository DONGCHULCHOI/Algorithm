package leetcode.programmers;

import java.util.*;

public class 모의고사 {
    // Brute force(iteration):
    /*
    문제 설명
    수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

    1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

    제한 조건
    시험은 최대 10,000 문제로 구성되어있습니다.
    문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
    입출력 예
    answers	return
    [1,2,3,4,5]	[1]
    [1,3,2,4,2]	[1,2,3]
    입출력 예 설명
    입출력 예 #1

    수포자 1은 모든 문제를 맞혔습니다.
    수포자 2는 모든 문제를 틀렸습니다.
    수포자 3은 모든 문제를 틀렸습니다.
    따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
     */
    public int[] solution(int[] answers) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < answers.length; j++) {
                if(i == 0) {
                    if(answers[j] == j % 5 + 1) {
                        map.put(i, map.getOrDefault(i, 0) + 1);
                    }
                }
                else if(i == 1) {
                    if(j % 2 == 0) {
                        if(answers[j] == 2) {
                            map.put(i, map.getOrDefault(i, 0) + 1);
                        }
                    }
                    else if(j % 8 == 1) {
                        if(answers[j] == 1) {
                            map.put(i, map.getOrDefault(i, 0) + 1);
                        }
                    }
                    else if(j % 8 == 3) {
                        if(answers[j] == 3) {
                            map.put(i, map.getOrDefault(i, 0) + 1);
                        }
                    }
                    else if(j % 8 == 5) {
                        if(answers[j] == 4) {
                            map.put(i, map.getOrDefault(i, 0) + 1);
                        }
                    }
                    else if(j % 8 == 7) {
                        if(answers[j] == 5) {
                            map.put(i, map.getOrDefault(i, 0) + 1);
                        }
                    }
                }
                else if(i == 2) {
                    if(j % 10 == 0 || j % 10 == 1) {
                        if(answers[j] == 3) {
                            map.put(i, map.getOrDefault(i, 0) + 1);
                        }
                    }
                    else if(j % 10 == 2 || j % 10 == 3) {
                        if(answers[j] == 1) {
                            map.put(i, map.getOrDefault(i, 0) + 1);
                        }
                    }
                    else if(j % 10 == 4 || j % 10 == 5) {
                        if(answers[j] == 2) {
                            map.put(i, map.getOrDefault(i, 0) + 1);
                        }
                    }
                    else if(j % 10 == 6 || j % 10 == 7) {
                        if(answers[j] == 4) {
                            map.put(i, map.getOrDefault(i, 0) + 1);
                        }
                    }
                    else if(j % 10 == 8 || j % 10 == 9) {
                        if(answers[j] == 5) {
                            map.put(i, map.getOrDefault(i, 0) + 1);
                        }
                    }
                }
            }
        }

        List<Integer> list = null;
        if(map.size() == 0) {
            return new int[]{};
        }
        else {
            list = new ArrayList<>();
            if(map.size() == 1) {
                for(int student : map.keySet()) {
                    list.add(student);
                }
            }
            else {
                List<Integer> students = new ArrayList<>();
                for(int student : map.keySet()) {
                    students.add(student);
                }

                Collections.sort(students,
                        (a, b) -> map.get(b) - map.get(a)
                );

                int maxVal = map.get(students.get(0));
                for(int student : students) {
                    if(maxVal == map.get(student)) {
                        list.add(student);
                    }
                }
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i) + 1;
        }
        return result;
    }
}
