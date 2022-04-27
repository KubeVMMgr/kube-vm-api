# 1. kube-vm-api
Java Client for [kube-vm](https://github.com/KubeVMMgr/kube-vm).

Note: kube-vm-api is a heavy work in progress.

**Authors**
- wuheng@otcaix.iscas.ac.cn
- wuyuewen@otcaix.iscas.ac.cn

# 2. Introduce Kube-vm

## 2.1 Kube-vm brief

**Kube-vm** is a Kubernetes-based virtual machine management platform, which extends [Kubernetes](https://kubernetes.io/) by adding
additional virtualization resource types through
[Kubernetes's Custom Resource Definitions API](https://kubernetes.io/docs/tasks/access-kubernetes-api/custom-resources/custom-resource-definitions/). By using this mechanism, the Kubernetes API can be used to manage these `VM`
resources alongside all other resources Kubernetes provides: 

- VirtualMachine:          kubectl get vm
- VirtualMachinePool:      kubectl get vmp
- VirtualMachineDisk:      kubectl get vmd
- VirtualMachineImage:     kubectl get vmi
- VirtualMachineDiskImage: kubectl get vmdi
- VirtualMachineSnapshot:  kubectl get vmsn
- VirtualMachineNetwork:   kubectl get vmn

**Note:** Kube-vm is a heavy work in progress.

# 3 roadmap
