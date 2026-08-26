class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        visitRoom(0, rooms, visited);

        for (boolean room : visited) {
            if (!room) {
                return false;
            }
        }

        return true;
    }

    public void visitRoom(int room, List<List<Integer>> rooms, boolean[] visited) {

        if (visited[room]) {
            return;
        }

        visited[room] = true;

        for (int key : rooms.get(room)) {
            visitRoom(key, rooms, visited);
        }
    }
}