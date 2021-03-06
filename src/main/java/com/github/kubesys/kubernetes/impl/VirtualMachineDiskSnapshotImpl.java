/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.regex.Pattern;

import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskSnapshot;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskSnapshotList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskSnapshotSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisksnapshot.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisksnapshot.Lifecycle.CreateDiskExternalSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisksnapshot.Lifecycle.DeleteDiskExternalSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisksnapshot.Lifecycle.RevertDiskExternalSnapshot;
import com.github.kubesys.kubernetes.utils.RegExpUtils;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class VirtualMachineDiskSnapshotImpl extends AbstractImpl<VirtualMachineDiskSnapshot, VirtualMachineDiskSnapshotList, VirtualMachineDiskSnapshotSpec> {

	@Override
	public VirtualMachineDiskSnapshot getModel() {
		return new VirtualMachineDiskSnapshot();
	}

	@Override
	public VirtualMachineDiskSnapshotSpec getSpec() {
		return new VirtualMachineDiskSnapshotSpec();
	}
	

	@Override
	public Object getLifecycle() {
		return new Lifecycle();
	}


	@Override
	public VirtualMachineDiskSnapshotSpec getSpec(VirtualMachineDiskSnapshot r) {
		return r.getSpec();
	}

	/*************************************************
	 * 
	 * Generated by <code>MethodGenerator<code>
	 * 
	 **************************************************/
	public boolean createDiskExternalSnapshot(String name, CreateDiskExternalSnapshot createDiskExternalSnapshot) throws Exception {
		return createDiskExternalSnapshot(name, null, createDiskExternalSnapshot, null);
	}

	public boolean createDiskExternalSnapshot(String name, String nodeName, CreateDiskExternalSnapshot createDiskExternalSnapshot) throws Exception {
		return createDiskExternalSnapshot(name, nodeName, createDiskExternalSnapshot, null);
	}

	public boolean createDiskExternalSnapshot(String name, CreateDiskExternalSnapshot createDiskExternalSnapshot, String eventId) throws Exception {
		return createDiskExternalSnapshot(name, null, createDiskExternalSnapshot, eventId);
	}

	public boolean createDiskExternalSnapshot(String name, String nodeName,CreateDiskExternalSnapshot createDiskExternalSnapshot, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createDiskExternalSnapshot)));
	}

	public boolean revertDiskExternalSnapshot(String name, RevertDiskExternalSnapshot revertDiskExternalSnapshot) throws Exception {
		return revertDiskExternalSnapshot(name, revertDiskExternalSnapshot, null);
	}

	public boolean revertDiskExternalSnapshot(String name, RevertDiskExternalSnapshot revertDiskExternalSnapshot, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), revertDiskExternalSnapshot);
	}

	public boolean revertDiskExternalSnapshot(String name, String nodeName, RevertDiskExternalSnapshot revertDiskExternalSnapshot) throws Exception {
		updateHost(name, nodeName);
		return revertDiskExternalSnapshot(name, revertDiskExternalSnapshot, null);
	}

	public boolean revertDiskExternalSnapshot(String name, String nodeName, RevertDiskExternalSnapshot revertDiskExternalSnapshot, String eventId) throws Exception {
		updateHost(name, nodeName);
		return revertDiskExternalSnapshot(name, revertDiskExternalSnapshot, eventId);
	}

	public boolean deleteDiskExternalSnapshot(String name, DeleteDiskExternalSnapshot deleteDiskExternalSnapshot) throws Exception {
		return deleteDiskExternalSnapshot(name, deleteDiskExternalSnapshot, null);
	}

	public boolean deleteDiskExternalSnapshot(String name, DeleteDiskExternalSnapshot deleteDiskExternalSnapshot, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return delete(name, updateMetadata(name, eventId), deleteDiskExternalSnapshot);
	}

	public boolean deleteDiskExternalSnapshot(String name, String nodeName, DeleteDiskExternalSnapshot deleteDiskExternalSnapshot) throws Exception {
		updateHost(name, nodeName);
		return deleteDiskExternalSnapshot(name, deleteDiskExternalSnapshot, null);
	}

	public boolean deleteDiskExternalSnapshot(String name, String nodeName, DeleteDiskExternalSnapshot deleteDiskExternalSnapshot, String eventId) throws Exception {
		updateHost(name, nodeName);
		return deleteDiskExternalSnapshot(name, deleteDiskExternalSnapshot, eventId);
	}
}
