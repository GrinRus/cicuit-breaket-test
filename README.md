run prometheus&grafana&app's
docker compose up -d

run k6 load test
K6_PROMETHEUS_RW_TREND_STATS=p(95),p(99),min,max \
k6 run -o experimental-prometheus-rw ./k6/test.js

grafana dashboards:
http://localhost:3000/dashboards
for apps:
Spring Boot 3.x Statistics
for k6 load tests:
k6 Prometheus