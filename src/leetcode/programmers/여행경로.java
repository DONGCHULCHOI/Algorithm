package leetcode.programmers;

import java.util.*;

public class 여행경로 {
    // DFS:
    /*
    문제 설명
    주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.

    항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

    제한사항
    모든 공항은 알파벳 대문자 3글자로 이루어집니다.
    주어진 공항 수는 3개 이상 10,000개 이하입니다.
    tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
    주어진 항공권은 모두 사용해야 합니다.
    만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
    모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
    입출력 예
    tickets	return
            [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
            [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
    입출력 예 설명
    예제 #1

            ["ICN", "JFK", "HND", "IAD"] 순으로 방문할 수 있습니다.

    예제 #2

            ["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] 순으로 방문할 수도 있지만 ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 가 알파벳 순으로 앞섭니다.
     */
    //String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
    //String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
    //String[][] tickets = {{"ICN","AAA"},{"ICN","AAA"},{"ICN","AAA"},{"AAA","ICN"},{"AAA","ICN"}};
    //String[][] tickets = {{"ICN","B"},{"B","ICN"},{"ICN","A"},{"A","D"},{"D","A"}};
    //String[][] tickets = {{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}};
    //String[][] tickets = {{"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"}, {"B", "A"}};
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[0].compareTo(b[0]) != a[0].compareTo(b[0]) ? 0 : a[1].compareTo(b[1]));

        List<String> answer = null;
        Set<String[]> visited = null;
        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals("ICN")) {
                answer = dfs(tickets, i, new ArrayList<>(), new HashSet<>());
                if(answer.size() == tickets.length + 1) {
                    break;
                }
            }
        }

        String[] ans = new String[tickets.length + 1];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }

    public static List<String> dfs(String[][] tickets, int start, List<String> answer, Set<String[]> visited) {
        answer.add(tickets[start][0]);
        visited.add(tickets[start]);
        if(answer.size() == tickets.length) {
            answer.add(tickets[start][1]);
            return answer;
        }

        for(int i = 0; i < tickets.length; i++) {
            if(!visited.contains(tickets[i]) && tickets[start][1].equals(tickets[i][0])) {
                List<String> tmp = dfs(tickets, i, answer, visited);
                if(tmp.size() == 0) {
                    visited.remove(tickets[i]);
                    answer.remove(answer.size() - 1);
                }
                if(answer.size() == tickets.length + 1) {
                    return answer;
                }

            }
        }
        return new ArrayList<>();
    }
}
