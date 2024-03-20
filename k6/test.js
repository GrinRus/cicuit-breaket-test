import http from 'k6/http'
import {check, sleep, group} from 'k6'

var duration = '120s'

export const options = {
    discardResponseBodies: true,
    scenarios: {
        call_app_1_getServiceString: {
            exec: 'call_app_1_getServiceString',
            executor: 'constant-arrival-rate',
            duration: duration,
            rate: 500,
            timeUnit: '1s',
            preAllocatedVUs: 200,
            maxVUs: 1000
        },
        call_app_1_getClientString: {
            exec: 'call_app_1_getClientString',
            executor: 'constant-arrival-rate',
            duration: duration,
            rate: 500,
            timeUnit: '1s',
            preAllocatedVUs: 200,
            maxVUs: 1000
        },
        call_app_2_getServiceString: {
            exec: 'call_app_2_getServiceString',
            executor: 'constant-arrival-rate',
            duration: duration,
            rate: 500,
            timeUnit: '1s',
            preAllocatedVUs: 200,
            maxVUs: 1000
        },
    },
};

export function call_app_1_getServiceString() {
    let res = http.get('http://localhost:8887/getServiceString')

    check(res, {'status is 200': (r) => r.status === 200})

    // sleep(0.1)
}

export function call_app_1_getClientString() {
    let res = http.get('http://localhost:8887/getClientString')

    check(res, {'status is 200': (r) => r.status === 200})

    // sleep(0.1)
}


export function call_app_2_getServiceString() {
    let res = http.get('http://localhost:8888/getServiceString')

    check(res, {'status is 200': (r) => r.status === 200})

    // sleep(0.1)
}
