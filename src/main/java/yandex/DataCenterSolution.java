import java.io.*;

public class DataCenterSolution {

    public static class Server {
        private boolean isEnable;

        public Server() {
            this.isEnable = true;
        }

        public void enable() {
            this.isEnable = true;
        }

        public void disable() {
            this.isEnable = false;
        }

        public boolean isEnable() {
            return isEnable;
        }
    }

    public static class DataCenter {
        private int amountResets;

        private final Server[] servers;

        public DataCenter(Server[] servers) {
            this.amountResets = 0;
            this.servers = servers;
        }

        public void reset() {
            amountResets++;
            for (Server server : servers) {
                server.enable();
            }
        }

        public void disableServer(int j) {
            servers[j].disable();
        }

        private int getAmountWorkingServers() {
            var amount = 0;
            for (Server server : servers) {
                if (server.isEnable) {
                    amount++;
                }
            }
            return amount;
        }

        public int getProduct() {
            return getAmountWorkingServers() * amountResets;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int q = Integer.parseInt(firstLine[2]);

        DataCenter[] dataCenters = new DataCenter[n];
        for (int i = 0; i < n; i++) {
            Server[] servers = new Server[m];
            for (int j = 0; j < m; j++) {
                servers[j] = new Server();
            }
            dataCenters[i] = new DataCenter(servers);
        }
        Integer lastIndexMax = null;
        Integer lastIndexMin = null;

        for (int l = 0; l < q; l++) {
            var line = reader.readLine().split(" ");
            switch (line[0]) {
                case "RESET": {
                    var i = Integer.parseInt(line[1]) - 1;
                    dataCenters[i].reset();
                    lastIndexMax = null;
                    lastIndexMin = null;
                    break;
                }
                case "DISABLE": {
                    var i = Integer.parseInt(line[1]) - 1;
                    var j = Integer.parseInt(line[2]) - 1;
                    dataCenters[i].disableServer(j);
                    lastIndexMax = null;
                    lastIndexMin = null;
                    break;
                }
                case "GETMAX": {
                    if (lastIndexMax != null) {
                        System.out.println(lastIndexMax);
                        break;
                    }
                    var max = Integer.MIN_VALUE;
                    var index = 1;
                    for (int i = 0; i < n; i++) {
                        var product = dataCenters[i].getProduct();
                        if (product > max) {
                            index = i + 1;
                            max = product;
                        }
                    }

                    System.out.println(index);
                    lastIndexMax = index;
                    break;
                }
                case "GETMIN": {
                    if (lastIndexMin != null) {
                        System.out.println(lastIndexMin);
                        break;
                    }
                    var min = Integer.MAX_VALUE;
                    var index = 1;
                    for (int i = 0; i < n; i++) {
                        var product = dataCenters[i].getProduct();
                        if (product < min) {
                            index = i + 1;
                            min = product;
                        }
                    }

                    System.out.println(index);
                    lastIndexMin = index;
                    break;
                }
            }
        }
    }
}